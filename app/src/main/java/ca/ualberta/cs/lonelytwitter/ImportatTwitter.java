package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by qpang on 1/19/17.
 */

public class ImportatTwitter extends  Twitter{
    public ImportatTwitter(String message) {
        super(message);

    }

    public ImportatTwitter(Date date, String message) {
        super(date, message);
    }

    @Override
    public Boolean isImportant(){
        return  false;
    }
    // yin wei fu lei shi chou xiaong suo yi chongxie fu lei fang fa
}
