import java.util.ArrayList;

public abstract class EdCourse {
    protected String name;
    protected boolean hasExam;

    public abstract void PrintFormat();
    public abstract void Input();

    public String getName()
    {
        return name;
    }

    public boolean getHasExam()
    {
        return hasExam;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setHasExam(boolean hasExam)
    {
        this.hasExam = hasExam;
    }


}
