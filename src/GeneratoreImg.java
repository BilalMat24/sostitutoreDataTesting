import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class GeneratoreImg {
    private static final String[] CAMS = {
        "cam100", "cam101", "cam102", "cam103", "cam104",
        "cam105", "cam106", "cam107", "cam108", "cam109"
    };

    private static final int WAIT = 5000; // 5 seconds
    private static final int DURATION_SECONDS = 60; // Limit execution to 60 seconds

    public static void main(String[] args) {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(CAMS.length);

        for (String cam : CAMS) {
            executorService.scheduleAtFixedRate(() -> {
                File sourceDir = getCartellaTest(cam);
                File destDir = getCartella(cam);
                processFiles(sourceDir, destDir, cam);
            }, 0, WAIT, TimeUnit.MILLISECONDS);
        }

        // Stop all tasks after 60 seconds
        Executors.newSingleThreadScheduledExecutor().schedule(() -> {
            executorService.shutdown();
            try {
                if (!executorService.awaitTermination(5, TimeUnit.SECONDS)) {
                    System.out.println("Forzando l'interruzione dei thread...");
                    executorService.shutdownNow();
                }
                System.out.println("Esecuzione terminata dopo 60 secondi.");
            } catch (InterruptedException e) {
                executorService.shutdownNow();
                Thread.currentThread().interrupt();
            }
        }, DURATION_SECONDS, TimeUnit.SECONDS);
    }

    private static void processFiles(File sourceDir, File destDir, String cam) {
        File[] files = sourceDir.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    File newFile = sostituisciNomeImmagine(file, sourceDir, cam);
                    try {
                        Thread.sleep(5000); // Add a small delay
                    } catch (InterruptedException e) {
                        System.out.println("Thread interrotto: " + Thread.currentThread().getName());
                        Thread.currentThread().interrupt();
                        return;
                    }
                    boolean renamed = file.renameTo(newFile);
                    if (renamed) {
                        try {
                            Path destPath = destDir.toPath().resolve(newFile.getName());
                            if (!Files.exists(destDir.toPath())) {
                                Files.createDirectories(destDir.toPath());
                            }
                            Files.copy(newFile.toPath(), destPath);
                            System.out.println("File copiato in: " + destPath);
                        } catch (IOException e) {
                            System.out.println("File non copiato: errore");
                            e.printStackTrace();
                        }
                    } else {
                        System.out.println("Errore file non rinominato");
                    }
                }
            }
        }
    }

    private static File sostituisciNomeImmagine(File file, File sourceDir, String cam) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        String timestamp = dateFormat.format(new Date());
        return new File(sourceDir + "/2024725000_" + timestamp + "_" + cam + ".jpg");
    }

    private static File getCartellaTest(String cam) {
        return new File("C:/Users/bilal.biaz/ProgettoVIT/TestControlloImmagini" + cam.substring(cam.length() - 3) + "/");
    }

    private static File getCartella(String cam) {
        return new File("C:/Users/bilal.biaz/ProgettoVIT/ControlloImmagini/nuovaImmagini/2024/11/21/" + cam + "/");
    }
}
