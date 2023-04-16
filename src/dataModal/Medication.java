package dataModal;

public class Medication {
    private Integer medCode ;
    private String medName;
    private String medComment;


    public Medication(Integer medCode, String medName, String medComment) {
        this.medCode = medCode;
        this.medName = medName;
        this.medComment = medComment;
    }

    public Integer getMedCode() {
        return medCode;
    }

    public void setMedCode(Integer medCode) {
        this.medCode = medCode;
    }

    public String getMedName() {
        return medName;
    }

    public void setMedName(String medName) {
        this.medName = medName;
    }

    public String getMedComment() {
        return medComment;
    }

    public void setMedComment(String medComment) {
        this.medComment = medComment;
    }

    @Override
    public String toString() {
        return "Medication{" +
                "medCode=" + medCode +
                ", medName='" + medName + '\'' +
                ", medComment='" + medComment + '\'' +
                '}';
    }
}
