package models.model;

public class AttendanceList {

    int classId;
    int userId;
    String Status;



    public AttendanceList(int id, int classId, int userId, String status) {

        this.classId = classId;
        this.userId = userId;
        Status = status;
    }


    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }
}


