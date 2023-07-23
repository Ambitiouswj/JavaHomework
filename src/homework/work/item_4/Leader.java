package homework.work.item_4;

public class Leader implements CallBack {
    private String name;
    private Worker worker;
    private String wayOfCallBack;

    public Leader(String name, Worker worker, String wayOfCallBack) {
        this.name = name;
        this.worker = worker;
        this.wayOfCallBack = wayOfCallBack;
    }

    public void finishTask(int second) {
        System.out.println(this.name + "的任务完成, 历时 " + second + " 秒，" + wayOfCallBack +"回复");
    }

    public String getName() { return this.name; }

    public void sendTask() {
        for(int i = 0; i < 5; i++) {
            int second = (int)(Math.random() * 100.0) + 1;
            try {
                Thread.sleep(second);
                this.worker.receiveTask(this);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}