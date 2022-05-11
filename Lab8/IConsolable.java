public interface IConsolable {
    String TableLine = "——————————————————————————————————————————————————————————————————————————————";

    static void OutputTableLine()
    {
        System.out.println(TableLine);
    }

    void PrintFormat();
    void Input();
}
