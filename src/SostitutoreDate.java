import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;

public class SostitutoreDate {
    private static final String cam100 = "_cam100";
    private static final String cam101 = "_cam101";
    private static final String cam102 = "_cam102";
    private static final String cam103 = "_cam103";
    private static final String cam104 = "_cam104";
    private static final String cam105 = "_cam105";
    private static final String cam106 = "_cam106";
    private static final String cam107 = "_cam107";
    private static final String cam108 = "_cam108";
    private static final String cam109 = "_cam109";

    private static int GIRI = 6; // il programma elabora 10 img al secondo, quindi 6 giri sono 60 img al minuto
    private static int WAIT = 1000; // aspetto 1000 millisecondi(1s)
    public static void main(String[] args) {

        // File[] files = getCartella().listFiles() spostato all'interno del primo for così viene aggiornato ad ongi ciclo con i nuovi nomi delle img

        Scanner scanner = new Scanner(System.in); //System.in is a standard input stream
        System.out.print("Digita ora per le Ore oppure minuti per i Minuti: ");
        String c = scanner.nextLine();
        int minuto = 0;
        if (c.equals("minuti")) {

            System.out.print("Scegli minuti: ");
            int scegliMinuto = scanner.nextInt();
            minuto = GIRI * scegliMinuto;
            System.out.println("Il valore in secondi è: " + (minuto * 10));
            scanner.close();
            System.out.print("Scegli minuti: ");
        } else if (c.equals("ora")) {

            System.out.print("Scegli Ora: ");
            int scegliOra = scanner.nextInt();
            int ora = GIRI * (scegliOra*60) ;
            System.out.println("Il valore in secondi è: " + (ora * 10));
            scanner.close();
            minuto = ora;
        }
        boolean rename101 = false;
        for (int j = 0; j < minuto; j++) {
            File[] files = getCartella().listFiles(); // spostato all interno del primo in modo tale che venga aggiornato
            System.out.println("copiate: " + (j * 10) + " immagini");
            for (int i = 0; i < files.length; i++) {
                if (files[i].isFile()) {

                    File newFile101 = sostituisciNomeImmagine101(files[i]);

                    rename101 = files[i].renameTo(newFile101);   // Da sistemare

                    System.out.println(files[i]);

                    try {
                        Path destPath101 = getCartella101().toPath().resolve(newFile101.getName());
                        Files.copy(newFile101.toPath(), destPath101 /*StandardCopyOption.REPLACE_EXISTING*/);
                        System.out.println("File copiato in: " + destPath101);

                    } catch (IOException e) {
                        System.out.println("File non copiato: errore");
                        e.printStackTrace();
                    }
                    try {
                        Thread.sleep(WAIT);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                    if (rename101 == true) {
                        System.out.println("file rinominato");
                    } else {
                        System.out.println("errore file non rinominato");
                    }
                }

            }
        }
    }

    public static File getCartella() {
        String pathCartella = "C:/Users/bilal.biaz/ProgettoVIT/TestControlloImmagini/";
        return new File(pathCartella);
    }

    public static File getCartella101() {
        String pathCartella101 = "C:/Users/bilal.biaz/ProgettoVIT/ControlloImmagini/nuovaImmagini/2024/11/08/cam101/";
        return new File(pathCartella101);
    }



    public static File sostituisciNomeImmagine101(File file1) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        String timestamp = dateFormat.format(new Date());
        return new File(getCartella() + "/2024725000_" + timestamp + cam101 + ".jpg");
    }

    //Metodo non utlizzato
    public static File[] sostituisciNomeImmagineDinamico(File[] file){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        String timestamp = dateFormat.format(new Date());
        File cam100XFile = new File(getCartella() + "/2024725000_" + timestamp + cam100 + ".jpg");
        File cam101XFile = new File(getCartella() + "/2024725000_" + timestamp + cam101 + ".jpg");
        File cam102XFile = new File(getCartella() + "/2024725000_" + timestamp + cam102 + ".jpg");
        File cam103XFile = new File(getCartella() + "/2024725000_" + timestamp + cam103 + ".jpg");
        File cam104XFile = new File(getCartella() + "/2024725000_" + timestamp + cam104 + ".jpg");
        File cam105XFile = new File(getCartella() + "/2024725000_" + timestamp + cam105 + ".jpg");
        File cam106XFile = new File(getCartella() + "/2024725000_" + timestamp + cam106 + ".jpg");
        File cam107XFile = new File(getCartella() + "/2024725000_" + timestamp + cam107 + ".jpg");
        File cam108XFile = new File(getCartella() + "/2024725000_" + timestamp + cam108 + ".jpg");
        File cam109XFile = new File(getCartella() + "/2024725000_" + timestamp + cam109 + ".jpg");

        File[] cams = {cam100XFile,cam101XFile, cam102XFile, cam103XFile, cam104XFile ,cam105XFile, cam106XFile, cam107XFile, cam108XFile, cam109XFile};
        return cams;
    }

}
