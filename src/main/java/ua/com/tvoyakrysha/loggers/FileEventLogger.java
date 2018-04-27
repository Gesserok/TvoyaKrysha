package ua.com.tvoyakrysha.loggers;

import org.apache.commons.io.FileUtils;
import ua.com.tvoyakrysha.exceptions.FileReadException;
import ua.com.tvoyakrysha.exceptions.FileWriteException;
import ua.com.tvoyakrysha.model.Event;

import java.io.File;
import java.io.IOException;

public class FileEventLogger implements EventLogger {

    private File file;
    private String fileName;

    public void logEvent(Event event){
        try {
            FileUtils.writeStringToFile(file, event.toString()+"\r\n",true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public FileEventLogger() {
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    private void init() throws IOException, FileReadException, FileWriteException {
        file = new File(fileName);
        if (file.exists()) {
            if (!file.canRead()) throw new FileReadException();
            if (!file.canWrite()) throw new FileWriteException();
        } else {
            file.createNewFile();
        }
        System.out.println("init-method");
    }

}
