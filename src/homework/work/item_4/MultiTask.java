package homework.work.item_4;

import java.util.*;

public class MultiTask {
    private List<Leader> leaders;
    private Worker worker;
    private static final Map<String,String> leadersNames = Map.ofEntries(
            Map.entry("lyz", "打电话"),
            Map.entry("lxy", "发微信"),
            Map.entry("mzw", "发QQ"),
            Map.entry("wj", "发E-mail"),
            Map.entry("zxl", "无")
    );
    public MultiTask() {
        this.leaders = new ArrayList<>();
        this.worker = new Worker();
    }

    public void setLeaders() {
        for (Map.Entry<String,String> entry : leadersNames.entrySet()) {
            this.leaders.add(new Leader(entry.getKey(), this.worker, entry.getValue()));
        }
    }

    public void takeTasks() {
        this.setLeaders();
        Iterator leaderIterator = this.leaders.iterator();
        while (leaderIterator.hasNext()) {
            Leader leader = (Leader)leaderIterator.next();
            (new Thread(() -> {leader.sendTask();} )).start();
        }
        Thread workingThread = new Thread(() -> {this.worker.Working();} );
        workingThread.start();
        while(workingThread.isAlive()) {
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}