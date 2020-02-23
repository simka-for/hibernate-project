public class Request {
    public static final String fillLinkedPurchaseList = "INSERT into " + "LinkedPurchaseList (studentId, " +
            "courseId, price, subscriptionDate) " +
            "SELECT " +
            "student.id, course.id, course.price, " +
            "subscription.subscriptionDate FROM Course course INNER JOIN Subscription subscription on subscription.subscriptionId.courseId = course.id  " +
            "INNER JOIN Student student on student.id = subscription.subscriptionId.studentId";
}
