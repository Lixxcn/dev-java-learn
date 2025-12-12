package proxy;

public class DigitalStudent {
    private Student student=new Student();
    public DigitalStudent(Student _student)
    {
        this.student=_student;
    }

    public void answer(String question)
    {
        this.student.answer(question);
    }
}
