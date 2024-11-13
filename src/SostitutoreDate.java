import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
public class SostitutoreDate {

    private static final String cam101 = "_cam101";
    private static int SECONDI = 86400;

    public static void main(String[] args) {


        File[] files = getCartella().listFiles();
        System.out.println("nella cartella di sono " + files.length + " file");
        boolean rename101 = false;


      for (int i = 0; i < files.length; i++) {
          if (files[i].isFile()) {

              File newFile101 = sostituisciNomeImmagine101(files[i]);

              rename101 = files[i].renameTo(newFile101);

              System.out.println(files[i]);

              try {
                  Path destPath101 = getCartella101().toPath().resolve(newFile101.getName());
                  Files.copy(newFile101.toPath(), destPath101, StandardCopyOption.REPLACE_EXISTING);
                  System.out.println("File copiato in: " + destPath101);

              } catch (IOException e) {
                  System.out.println("File non copiato: errore");
                  e.printStackTrace();
              }
              try {
                  Thread.sleep(1000
                  );
              } catch (Exception e) {
                  throw new RuntimeException(e);
              }
          }
          if (rename101 == true) {
              System.out.println("file rinominato");
          } else {
              System.out.println("errore");
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
        String timestamp = dateFormat.format(new Date());;
        return new File(getCartella() + "/2024725000_" + timestamp + cam101 + ".jpg");
    }

    //Metodo non utlizzato
/*    public static File[] sostituisciNomeImmagineDinamico(File[] file){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        String timestamp = dateFormat.format(new Date());
        File cam101File = new File(getCartella() + "/2024725000_" + timestamp + cam101 + ".jpg");
        File cam100XFile = new File(getCartella() + "/2024725000_" + timestamp + cam100 + ".jpg");
        File cam10XFile = new File(getCartella() + "/2024725000_" + timestamp + cam10 + ".jpg");
        File[] cams = {cam10XFile,cam100XFile, cam101File};
        return cams;
    }*/

}
