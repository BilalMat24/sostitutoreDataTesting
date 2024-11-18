
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
        boolean rename100 = false;
        boolean rename101 = false;
        boolean rename102 = false;
        boolean rename103 = false;
        boolean rename104 = false;
        boolean rename105 = false;
        boolean rename106 = false;
        boolean rename107 = false;
        boolean rename108 = false;
        boolean rename109 = false;


        for (int j = 0; j < minuto; j++) {
            File[] files = getCartellaTest100().listFiles(); // spostato all interno del primo in modo tale che venga aggiornato
            System.out.println("copiate: " + (j * 10) + " immagini");
            for (int i = 0; i < files.length; i++) {
                if (files[i].isFile()) {

                    File newFile100 = sostituisciNomeImmagine100(files[i]);

                    rename100 = files[i].renameTo(newFile100);   // Da sistemare

                    System.out.println(files[i]);

                    try {
                        Path destPath100 = getCartella100().toPath().resolve(newFile100.getName());
                        Files.copy(newFile100.toPath(), destPath100 /*StandardCopyOption.REPLACE_EXISTING*/);
                        System.out.println("File copiato in: " + destPath100);

                    } catch (IOException e) {
                        System.out.println("File non copiato: errore");
                        e.printStackTrace();
                    }
                    try {
                        Thread.sleep(WAIT);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                    if (rename100 == true) {
                        System.out.println("file rinominato");
                    } else {
                        System.out.println("errore file non rinominato");
                    }
                }

            }
        }


        for (int j = 0; j < minuto; j++) {
            File[] files = getCartellaTest101().listFiles(); // spostato all interno del primo in modo tale che venga aggiornato
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

        for (int j = 0; j < minuto; j++) {
            File[] files = getCartellaTest102().listFiles(); // spostato all interno del primo in modo tale che venga aggiornato
            System.out.println("copiate: " + (j * 10) + " immagini");
            for (int i = 0; i < files.length; i++) {
                if (files[i].isFile()) {

                    File newFile102 = sostituisciNomeImmagine102(files[i]);

                    rename102 = files[i].renameTo(newFile102);   // Da sistemare

                    System.out.println(files[i]);

                    try {
                        Path destPath102 = getCartella102().toPath().resolve(newFile102.getName());
                        Files.copy(newFile102.toPath(), destPath102 /*StandardCopyOption.REPLACE_EXISTING*/);
                        System.out.println("File copiato in: " + destPath102);

                    } catch (IOException e) {
                        System.out.println("File non copiato: errore");
                        e.printStackTrace();
                    }
                    try {
                        Thread.sleep(WAIT);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                    if (rename102 == true) {
                        System.out.println("file rinominato");
                    } else {
                        System.out.println("errore file non rinominato");
                    }
                }

            }
        }

        for (int j = 0; j < minuto; j++) {
            File[] files = getCartellaTest103().listFiles(); // spostato all interno del primo in modo tale che venga aggiornato
            System.out.println("copiate: " + (j * 10) + " immagini");
            for (int i = 0; i < files.length; i++) {
                if (files[i].isFile()) {

                    File newFile103 = sostituisciNomeImmagine103(files[i]);

                    rename103 = files[i].renameTo(newFile103);   // Da sistemare

                    System.out.println(files[i]);

                    try {
                        Path destPath103 = getCartella103().toPath().resolve(newFile103.getName());
                        Files.copy(newFile103.toPath(), destPath103 /*StandardCopyOption.REPLACE_EXISTING*/);
                        System.out.println("File copiato in: " + destPath103);

                    } catch (IOException e) {
                        System.out.println("File non copiato: errore");
                        e.printStackTrace();
                    }
                    try {
                        Thread.sleep(WAIT);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                    if (rename103 == true) {
                        System.out.println("file rinominato");
                    } else {
                        System.out.println("errore file non rinominato");
                    }
                }

            }
        }

        for (int j = 0; j < minuto; j++) {
            File[] files = getCartellaTest104().listFiles(); // spostato all interno del primo in modo tale che venga aggiornato
            System.out.println("copiate: " + (j * 10) + " immagini");
            for (int i = 0; i < files.length; i++) {
                if (files[i].isFile()) {

                    File newFile104 = sostituisciNomeImmagine104(files[i]);

                    rename104 = files[i].renameTo(newFile104);   // Da sistemare

                    System.out.println(files[i]);

                    try {
                        Path destPath104 = getCartella104().toPath().resolve(newFile104.getName());
                        Files.copy(newFile104.toPath(), destPath104 /*StandardCopyOption.REPLACE_EXISTING*/);
                        System.out.println("File copiato in: " + destPath104);

                    } catch (IOException e) {
                        System.out.println("File non copiato: errore");
                        e.printStackTrace();
                    }
                    try {
                        Thread.sleep(WAIT);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                    if (rename104 == true) {
                        System.out.println("file rinominato");
                    } else {
                        System.out.println("errore file non rinominato");
                    }
                }

            }
        }

        for (int j = 0; j < minuto; j++) {
            File[] files = getCartellaTest105().listFiles(); // spostato all interno del primo in modo tale che venga aggiornato
            System.out.println("copiate: " + (j * 10) + " immagini");
            for (int i = 0; i < files.length; i++) {
                if (files[i].isFile()) {

                    File newFile105 = sostituisciNomeImmagine105(files[i]);

                    rename105 = files[i].renameTo(newFile105);   // Da sistemare

                    System.out.println(files[i]);

                    try {
                        Path destPath105 = getCartella105().toPath().resolve(newFile105.getName());
                        Files.copy(newFile105.toPath(), destPath105 /*StandardCopyOption.REPLACE_EXISTING*/);
                        System.out.println("File copiato in: " + destPath105);

                    } catch (IOException e) {
                        System.out.println("File non copiato: errore");
                        e.printStackTrace();
                    }
                    try {
                        Thread.sleep(WAIT);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                    if (rename105 == true) {
                        System.out.println("file rinominato");
                    } else {
                        System.out.println("errore file non rinominato");
                    }
                }

            }
        }

        for (int j = 0; j < minuto; j++) {
            File[] files = getCartellaTest106().listFiles(); // spostato all interno del primo in modo tale che venga aggiornato
            System.out.println("copiate: " + (j * 10) + " immagini");
            for (int i = 0; i < files.length; i++) {
                if (files[i].isFile()) {

                    File newFile106 = sostituisciNomeImmagine106(files[i]);

                    rename106 = files[i].renameTo(newFile106);   // Da sistemare

                    System.out.println(files[i]);

                    try {
                        Path destPath106 = getCartella106().toPath().resolve(newFile106.getName());
                        Files.copy(newFile106.toPath(), destPath106 /*StandardCopyOption.REPLACE_EXISTING*/);
                        System.out.println("File copiato in: " + destPath106);

                    } catch (IOException e) {
                        System.out.println("File non copiato: errore");
                        e.printStackTrace();
                    }
                    try {
                        Thread.sleep(WAIT);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                    if (rename106 == true) {
                        System.out.println("file rinominato");
                    } else {
                        System.out.println("errore file non rinominato");
                    }
                }

            }
        }

        for (int j = 0; j < minuto; j++) {
            File[] files = getCartellaTest107().listFiles(); // spostato all interno del primo in modo tale che venga aggiornato
            System.out.println("copiate: " + (j * 10) + " immagini");
            for (int i = 0; i < files.length; i++) {
                if (files[i].isFile()) {

                    File newFile107 = sostituisciNomeImmagine107(files[i]);

                    rename107 = files[i].renameTo(newFile107);   // Da sistemare

                    System.out.println(files[i]);

                    try {
                        Path destPath107 = getCartella107().toPath().resolve(newFile107.getName());
                        Files.copy(newFile107.toPath(), destPath107 /*StandardCopyOption.REPLACE_EXISTING*/);
                        System.out.println("File copiato in: " + destPath107);

                    } catch (IOException e) {
                        System.out.println("File non copiato: errore");
                        e.printStackTrace();
                    }
                    try {
                        Thread.sleep(WAIT);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                    if (rename107 == true) {
                        System.out.println("file rinominato");
                    } else {
                        System.out.println("errore file non rinominato");
                    }
                }

            }
        }

        for (int j = 0; j < minuto; j++) {
            File[] files = getCartellaTest108().listFiles(); // spostato all interno del primo in modo tale che venga aggiornato
            System.out.println("copiate: " + (j * 10) + " immagini");
            for (int i = 0; i < files.length; i++) {
                if (files[i].isFile()) {

                    File newFile108 = sostituisciNomeImmagine108(files[i]);

                    rename108 = files[i].renameTo(newFile108);   // Da sistemare

                    System.out.println(files[i]);

                    try {
                        Path destPath108 = getCartella108().toPath().resolve(newFile108.getName());
                        Files.copy(newFile108.toPath(), destPath108 /*StandardCopyOption.REPLACE_EXISTING*/);
                        System.out.println("File copiato in: " + destPath108);

                    } catch (IOException e) {
                        System.out.println("File non copiato: errore");
                        e.printStackTrace();
                    }
                    try {
                        Thread.sleep(WAIT);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                    if (rename108 == true) {
                        System.out.println("file rinominato");
                    } else {
                        System.out.println("errore file non rinominato");
                    }
                }

            }
        }

        for (int j = 0; j < minuto; j++) {
            File[] files = getCartellaTest109().listFiles(); // spostato all interno del primo in modo tale che venga aggiornato
            System.out.println("copiate: " + (j * 10) + " immagini");
            for (int i = 0; i < files.length; i++) {
                if (files[i].isFile()) {

                    File newFile109 = sostituisciNomeImmagine109(files[i]);

                    rename109 = files[i].renameTo(newFile109);   // Da sistemare

                    System.out.println(files[i]);

                    try {
                        Path destPath109 = getCartella109().toPath().resolve(newFile109.getName());
                        Files.copy(newFile109.toPath(), destPath109 /*StandardCopyOption.REPLACE_EXISTING*/);
                        System.out.println("File copiato in: " + destPath109);

                    } catch (IOException e) {
                        System.out.println("File non copiato: errore");
                        e.printStackTrace();
                    }
                    try {
                        Thread.sleep(WAIT);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                    if (rename109 == true) {
                        System.out.println("file rinominato");
                    } else {
                        System.out.println("errore file non rinominato");
                    }
                }

            }
        }
    }


    public static File getCartellaTest100() {
        String pathCartella = "C:/Users/bilal.biaz/ProgettoVIT/TestControlloImmagini100/";
        return new File(pathCartella);
    }
    public static File getCartellaTest101() {
        String pathCartella = "C:/Users/bilal.biaz/ProgettoVIT/TestControlloImmagini101/";
        return new File(pathCartella);
    }
    public static File getCartellaTest102() {
        String pathCartella = "C:/Users/bilal.biaz/ProgettoVIT/TestControlloImmagini102/";
        return new File(pathCartella);
    }
    public static File getCartellaTest103() {
        String pathCartella = "C:/Users/bilal.biaz/ProgettoVIT/TestControlloImmagini103/";
        return new File(pathCartella);
    }
    public static File getCartellaTest104() {
        String pathCartella = "C:/Users/bilal.biaz/ProgettoVIT/TestControlloImmagini104/";
        return new File(pathCartella);
    }
    public static File getCartellaTest105() {
        String pathCartella = "C:/Users/bilal.biaz/ProgettoVIT/TestControlloImmagini105/";
        return new File(pathCartella);
    }
    public static File getCartellaTest106() {
        String pathCartella = "C:/Users/bilal.biaz/ProgettoVIT/TestControlloImmagini106/";
        return new File(pathCartella);
    }
    public static File getCartellaTest107() {
        String pathCartella = "C:/Users/bilal.biaz/ProgettoVIT/TestControlloImmagini107/";
        return new File(pathCartella);
    }
    public static File getCartellaTest108() {
        String pathCartella = "C:/Users/bilal.biaz/ProgettoVIT/TestControlloImmagini108/";
        return new File(pathCartella);
    }
    public static File getCartellaTest109() {
        String pathCartella = "C:/Users/bilal.biaz/ProgettoVIT/TestControlloImmagini109/";
        return new File(pathCartella);
    }

    public static File getCartella100() {
        String pathCartella100 = "C:/Users/bilal.biaz/ProgettoVIT/ControlloImmagini/nuovaImmagini/2024/11/14/cam100/";  // AGGIORNARE IN CASO DI CAMBIO NOME FOLDER
        return new File(pathCartella100);
    }
    public static File getCartella101() {
        String pathCartella101 = "C:/Users/bilal.biaz/ProgettoVIT/ControlloImmagini/nuovaImmagini/2024/11/14/cam101/";  // AGGIORNARE IN CASO DI CAMBIO NOME FOLDER
        return new File(pathCartella101);
    }
    public static File getCartella102() {
        String pathCartella102 = "C:/Users/bilal.biaz/ProgettoVIT/ControlloImmagini/nuovaImmagini/2024/11/14/cam102/";  // AGGIORNARE IN CASO DI CAMBIO NOME FOLDER
        return new File(pathCartella102);
    }
    public static File getCartella103() {
        String pathCartella103 = "C:/Users/bilal.biaz/ProgettoVIT/ControlloImmagini/nuovaImmagini/2024/11/14/cam103/";  // AGGIORNARE IN CASO DI CAMBIO NOME FOLDER
        return new File(pathCartella103);
    }
    public static File getCartella104() {
        String pathCartella104 = "C:/Users/bilal.biaz/ProgettoVIT/ControlloImmagini/nuovaImmagini/2024/11/14/cam104/";  // AGGIORNARE IN CASO DI CAMBIO NOME FOLDER
        return new File(pathCartella104);
    }
    public static File getCartella105() {
        String pathCartella105 = "C:/Users/bilal.biaz/ProgettoVIT/ControlloImmagini/nuovaImmagini/2024/11/14/cam105/";  // AGGIORNARE IN CASO DI CAMBIO NOME FOLDER
        return new File(pathCartella105);
    }
    public static File getCartella106() {
        String pathCartella106 = "C:/Users/bilal.biaz/ProgettoVIT/ControlloImmagini/nuovaImmagini/2024/11/14/cam106/";  // AGGIORNARE IN CASO DI CAMBIO NOME FOLDER
        return new File(pathCartella106);
    }
    public static File getCartella107() {
        String pathCartella107 = "C:/Users/bilal.biaz/ProgettoVIT/ControlloImmagini/nuovaImmagini/2024/11/14/cam107/";  // AGGIORNARE IN CASO DI CAMBIO NOME FOLDER
        return new File(pathCartella107);
    }
    public static File getCartella108() {
        String pathCartella108 = "C:/Users/bilal.biaz/ProgettoVIT/ControlloImmagini/nuovaImmagini/2024/11/14/cam108/";  // AGGIORNARE IN CASO DI CAMBIO NOME FOLDER
        return new File(pathCartella108);
    }
    public static File getCartella109() {
        String pathCartella109 = "C:/Users/bilal.biaz/ProgettoVIT/ControlloImmagini/nuovaImmagini/2024/11/14/cam109/";  // AGGIORNARE IN CASO DI CAMBIO NOME FOLDER
        return new File(pathCartella109);
    }


    public static File sostituisciNomeImmagine100(File file0) {   // sostituisce il nome dell'immagine alla data attuale nella folder TestControllloImmagini...
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        String timestamp = dateFormat.format(new Date());
        return new File(getCartellaTest100() + "/2024725000_" + timestamp + cam100 + ".jpg");
    }
    public static File sostituisciNomeImmagine101(File file1) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        String timestamp = dateFormat.format(new Date());
        return new File(getCartellaTest101() + "/2024725000_" + timestamp + cam101 + ".jpg");
    }
    public static File sostituisciNomeImmagine102(File file2) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        String timestamp = dateFormat.format(new Date());
        return new File(getCartellaTest102() + "/2024725000_" + timestamp + cam102 + ".jpg");
    }
    public static File sostituisciNomeImmagine103(File file3) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        String timestamp = dateFormat.format(new Date());
        return new File(getCartellaTest103() + "/2024725000_" + timestamp + cam103 + ".jpg");
    }
    public static File sostituisciNomeImmagine104(File file4) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        String timestamp = dateFormat.format(new Date());
        return new File(getCartellaTest104() + "/2024725000_" + timestamp + cam104 + ".jpg");
    }
    public static File sostituisciNomeImmagine105(File file5) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        String timestamp = dateFormat.format(new Date());
        return new File(getCartellaTest105() + "/2024725000_" + timestamp + cam105 + ".jpg");
    }
    public static File sostituisciNomeImmagine106(File file6) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        String timestamp = dateFormat.format(new Date());
        return new File(getCartellaTest106() + "/2024725000_" + timestamp + cam106 + ".jpg");
    }
    public static File sostituisciNomeImmagine107(File file7) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        String timestamp = dateFormat.format(new Date());
        return new File(getCartellaTest107() + "/2024725000_" + timestamp + cam107 + ".jpg");
    }
    public static File sostituisciNomeImmagine108(File file8) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        String timestamp = dateFormat.format(new Date());
        return new File(getCartellaTest108() + "/2024725000_" + timestamp + cam108 + ".jpg");
    }
    public static File sostituisciNomeImmagine109(File file9) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        String timestamp = dateFormat.format(new Date());
        return new File(getCartellaTest109() + "/2024725000_" + timestamp + cam109 + ".jpg");
    }



}
