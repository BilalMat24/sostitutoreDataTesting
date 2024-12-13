import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class SostitutoreDate {
    private static final String[] CAMS = {
            "cam2", "cam4", "cam5", "cam6", "cam8", "cam10", "cam11", "cam30", "cam31",
            "cam32", "cam34", "cam35", "cam37", "cam39", "cam40", "cam41", "cam42",
            "cam43", "cam44", "cam45", "cam46", "cam47", "cam48", "cam49", "cam50",
            "cam51", "cam52", "cam53", "cam54", "cam55", "cam56", "cam60", "cam61",
            "cam62", "cam63", "cam64", "cam65", "cam66", "cam67", "cam68", "cam69",
            "cam70", "cam71", "cam72", "cam73", "cam74", "cam75", "cam76", "cam77",
            "cam78", "cam79", "cam80", "cam81", "cam82", "cam83", "cam84", "cam85",
            "cam86", "cam87", "cam88", "cam89", "cam90", "cam91", "cam92", "cam93",
            "cam94", "cam95", "cam96", "cam97", "cam98", "cam99", "cam100", "cam101",
            "cam102", "cam103", "cam104", "cam105", "cam106", "cam107", "cam108",
            "cam109", "cam110", "cam111", "cam112", "cam113", "cam114", "cam115",
            "cam116", "cam117", "cam118", "cam119", "cam120", "cam121", "cam122",
            "cam123", "cam124", "cam125", "cam126", "cam127", "cam128", "cam129",
            "cam130", "cam132", "cam133"
    };


    private static final int WAIT = 5000; // 5 seconds
    private static final int DURATION_SECONDS = 10; // qui scegli per quanti secondi far runnare il programma

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
                System.out.println("Esecuzione terminata dopo "+DURATION_SECONDS+ " secondi.");
            } catch (InterruptedException e) {
                executorService.shutdownNow();
                Thread.currentThread().interrupt();
            }
        }, DURATION_SECONDS, TimeUnit.SECONDS);  // prova a cambiarlo in MINUTES
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

    private static File getCartella(String cam) {  // ricordarsi di cambiare il nome della cartella in caso fosse stato aggiorato in base alla data odierna
        return new File("C:/Users/bilal.biaz/ProgettoVIT/ControlloImmagini/nuovaImmagini/2024/12/12/" + cam + "/");
    }
}


// Un periodo di esecuzione dello script alto risulta restituire meno immagini del previsto. Es. se eseguito per un ora mi aspetterei 720 img ma ne ritrovo 719
// c'è una soglia di errore che aumenta all'incremento del tempo