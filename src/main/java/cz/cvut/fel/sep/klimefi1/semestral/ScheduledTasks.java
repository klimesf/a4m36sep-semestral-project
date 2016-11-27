package cz.cvut.fel.sep.klimefi1.semestral;

import cz.cvut.fel.sep.klimefi1.semestral.service.ChangeRequestUploader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTasks {

    @Autowired
    private ChangeRequestUploader changeRequestUploader;

    /**
     * Uploads ChangeRequests to external API each day at 3am from Monday to Friday.
     */
    @Scheduled(cron = "0 0 3 * * MON-FRI")
    public void uploadChangeRequests() {
        changeRequestUploader.upload();
    }

}
