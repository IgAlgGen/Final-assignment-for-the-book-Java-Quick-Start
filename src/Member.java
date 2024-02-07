public class Member {
    private char memberType;
    private int memberId;
    private String name;
    private double fees;

    public Member(char memberType, int memberId, String name, double fees) {
        this.memberType = memberType;
        this.memberId = memberId;
        this.name = name;
        this.fees = fees;
    }

    //region Getters Setters
    public char getMemberType() {
        return memberType;
    }

    public void setMemberType(char memberType) {
        this.memberType = memberType;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getFees() {
        return fees;
    }

    public void setFees(double fees) {
        this.fees = fees;
    }
    //endregion

    @Override
    public String toString(){
        return memberType+" "+memberId+" "+name+" "+fees;
    }
}
