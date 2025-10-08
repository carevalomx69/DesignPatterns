using System;

public class MotorAntiguo
{
    public void EncenderMotor()
    {
        Console.WriteLine("Motor antiguo encendido.");
    }
}

public interface IMotor
{
    void Encender();
}

public class AdaptadorMotor : IMotor
{
    private MotorAntiguo motorAntiguo;

    public AdaptadorMotor(MotorAntiguo motor)
    {
        motorAntiguo = motor;
    }

    public void Encender()
    {
        motorAntiguo.EncenderMotor();
    }
}

class Program
{
    static void Main()
    {
        MotorAntiguo motorAntiguo = new MotorAntiguo();
        IMotor motorAdaptado = new AdaptadorMotor(motorAntiguo);
        motorAdaptado.Encender();
    }
}
