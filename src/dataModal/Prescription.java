package dataModal;

public class Prescription {
    private Integer precId;
    private String precRef;
    private Integer precCode;
    private Integer precDays;

    public Prescription(Integer precId, String precRef, Integer precCode, Integer precDays) {
        this.precId = precId;
        this.precRef = precRef;
        this.precCode = precCode;
        this.precDays = precDays;
    }

    public Integer getPrecId() {
        return precId;
    }

    public void setPrecId(Integer precId) {
        this.precId = precId;
    }

    public String getPrecRef() {
        return precRef;
    }

    public void setPrecRef(String precRef) {
        this.precRef = precRef;
    }

    public Integer getPrecCode() {
        return precCode;
    }

    public void setPrecCode(Integer precCode) {
        this.precCode = precCode;
    }

    public Integer getPrecDays() {
        return precDays;
    }

    public void setPrecDays(Integer precDays) {
        this.precDays = precDays;
    }

    @Override
    public String toString() {
        return "Prescription{" +
                "precId=" + precId +
                ", precRef=" + precRef +
                ", precCode=" + precCode +
                ", precDays=" + precDays +
                '}';
    }
}
