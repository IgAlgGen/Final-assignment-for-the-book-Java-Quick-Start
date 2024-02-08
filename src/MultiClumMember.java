public class MultiClumMember extends Member {
    private int membershipPoint;

    public MultiClumMember(char memberType, int memberId, String name, double fees, int membershipPoint) {
        super(memberType, memberId, name, fees);
        this.membershipPoint = membershipPoint;
    }

    public int getMembershipPoint() {
        return membershipPoint;
    }

    public void setMembershipPoint(int membershipPoint) {
        this.membershipPoint = membershipPoint;
    }

    @Override
    public String toString() {
        return super.toString() + ", " + membershipPoint;
    }
}
