package com.example.demo.example.demomodel;
import org.springframework.stereotype.Repository;

@Repository
public class DemoModel
{
    private char driveLetter;
    private String driveName;
    private String driveType;
    private String totalSpace;
    private String freeSpace;

    public String getDriveName() {
        return driveName;
    }

    public void setDriveName(String driveName) {
        this.driveName = driveName;
    }

    public String getDriveType() {
        return driveType;
    }

    public void setDriveType(String driveType) {
        this.driveType = driveType;
    }

    public String getTotalSpace() {
        return totalSpace;
    }

    public void setTotalSpace(String totalSpace) {
        this.totalSpace = totalSpace;
    }

    public String getFreeSpace() {
        return freeSpace;
    }

    public void setFreeSpace(String freeSpace) {
        this.freeSpace = freeSpace;
    }

    public char getDriveLetter() { return driveLetter; }

    public void setDriveLetter(char driveLetter) { this.driveLetter = driveLetter; }

    @Override
    public String toString() {
        return "DeliveryDriveTestModel{" +
                "driveName='" + driveName + '\'' +
                ", driveType='" + driveType + '\'' +
                ", totalSpace='" + totalSpace + '\'' +
                ", freeSpace='" + freeSpace + '\'' +
                '}';
    }
}
