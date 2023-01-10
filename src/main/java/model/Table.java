// package model;

//import java.time.Duration;
//import java.time.LocalDateTime;
//import java.time.format.DateTimeFormatter;
//import java.time.temporal.Temporal;
//import java.util.UUID;

//public class Table {
//  private final String id;
//private final int x;
//private final double y;
//private final int r;
// private final String result;
//private final LocalDateTime currentTime;

//    private String formattedTime;

//    private final Double executionTime;


//    public Table(long id, int x, double y, int r, String result, LocalDateTime currentTime, Double executionTime) {
//        this.id = UUID.randomUUID().toString();
//        this.x = x;
//        this.y = y;
//        this.r = r;
//        this.result = result;
//        this.currentTime = LocalDateTime.parse(LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")));
//        this.executionTime = Duration.between(currentTime, LocalDateTime.now()).getNano() / 1000000000D;
//    }
//
//
//    public String getId() {
//        return id;
//    }
//
//    public int getX() {
//        return x;
//    }
//
//    public double getY() {
//        return y;
//    }
//
//    public int getR() {
//        return r;
//    }
//
//    public String getResult() {
//        return result;
//    }
//
//    public LocalDateTime getCurrentTime() {
//        return currentTime;
//    }
//
//    public Double getExecutionTime() {
//        return executionTime;
//    }
//
//
//  @Override
//    public String toString() {
//        return "Table{" +
//                "id='" + id + '\'' +
//                ", x=" + x +
//              ", y=" + y +
//                ", r=" + r +
//                ", result='" + result + '\'' +
//                ", currentTime='" + currentTime + '\'' +
//                ", executionTime='" + executionTime + '\'' +
//                '}';
//    }
//}

