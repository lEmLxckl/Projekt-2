package Svommeklubben;

import java.util.ArrayList;

public class Member {
    private String name;
    private int age;
    public String membershipType;
    public String swimmerType;
    private boolean hasPaid;

    public Member(String name, int age, String membershipType, String swimmerType, boolean isCompetitive) {
        this.name = name;
        this.age = age;
        this.membershipType = membershipType;
        this.swimmerType = swimmerType;
        this.hasPaid = false;
    }

    public String getName() {
        return name;
    }

    public String getMembershipType() {
        return membershipType;
    }

    public String getSwimmerType() {
        return swimmerType;
    }

    public boolean hasPaid() {
        return hasPaid;
    }

    public void setHasPaid(boolean hasPaid) {
        this.hasPaid = hasPaid;
    }

    public int calculateAnnualFee() {
        int baseFee = 0;

        if (membershipType.equalsIgnoreCase("active")) {
            if (swimmerType.equalsIgnoreCase("junior")) {
                baseFee = 1000;
            } else if (swimmerType.equalsIgnoreCase("senior")) {
                baseFee = 1600;
                if (age > 60) {
                    baseFee -= 0.25 * baseFee; // 25% discount for seniors over 60
                }
            }
        } else if (membershipType.equalsIgnoreCase("passive")) {
            baseFee = 500;
        }

        return baseFee;
    }
}
