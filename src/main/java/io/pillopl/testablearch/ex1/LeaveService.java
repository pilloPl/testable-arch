package io.pillopl.testablearch.ex1;


public class LeaveService {

   final LeaveDatabase database;
   final MessageBus messageBus;
   final EmailSender emailSender;
   final EscalationManager escalationManager;

    LeaveService(LeaveDatabase database, MessageBus messageBus, EmailSender emailSender, EscalationManager escalationManager) {
        this.database = database;
        this.messageBus = messageBus;
        this.emailSender = emailSender;
        this.escalationManager = escalationManager;
    }

    public Result requestPaidDaysOff(int days, Long employeeId) {
        if (days < 0) {
            throw new IllegalArgumentException();
        }

        Result result = null;

        Object[] employeeData = database.findByEmployeeId(employeeId);

        String employeeStatus = (String) employeeData[0];
        int daysSoFar = (Integer) employeeData[1];

        if (daysSoFar + days > 26) {

            if (employeeStatus.equals("PERFORMER") && daysSoFar + days < 45) {
                result = Result.Manual;
                escalationManager.notifyNewPendingRequest(employeeId);
            } else {
                result = Result.Denied;
                emailSender.send("next time");
            }

        } else {

            if (employeeStatus.equals("SLACKER")) {
                result = Result.Denied;
                emailSender.send("next time");
            } else {
                employeeData[1] = daysSoFar + days;
                result = Result.Approved;
                database.save(employeeData);
                messageBus.sendEvent("request approved");
            }
        }

        return result;
    }
}

class LeaveDatabase {

    Object[] findByEmployeeId(Long employeeId) {
        return new Object[0];
    }

    void save(Object[] employeeData) {

    }
}

class MessageBus {

    void sendEvent(String msg) {
    }
}

class EmailSender {

    void send(String msg) {
    }
}

class EscalationManager {

    void notifyNewPendingRequest(Long employeeId) {
    }
}

class Configuration {

    int getMaxDaysForPerformers() {
        return 45;
    }

    int getMaxDays() {
        return 26;
    }

}