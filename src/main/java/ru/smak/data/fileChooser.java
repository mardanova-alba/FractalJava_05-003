package ru.smak.data;

import ru.smak.graphics.ColorFunctionDark;
import ru.smak.graphics.Plane;
import ru.smak.gui.GraphicsPanel;
import ru.smak.math.fractals.MandelbrotX2;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;

public class fileChooser
{
    private int MandelbrotXi;
    private  int CurrentColorI;
    private Plane PlaneSave;
    private MandelbrotX2 MandelbrotSave;
    private ColorFunctionDark ColorSave;
    private final JFileChooser FileChooser = new JFileChooser();
    private GraphicsPanel graphicsPanel;
    private  String path;
   private  dataPut dataPut = new dataPut();

    public fileChooser(GraphicsPanel graphicsPanel)
    {
        this.graphicsPanel = graphicsPanel;
        FileChooser.setDialogTitle("Сохранение файла");
        // Определение режима - только файл
        FileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        // Фильтр
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "JSON", "JSON");
        FileChooser.setFileFilter(filter);
        this.graphicsPanel = graphicsPanel;
    }
    public void SaveFile()
    {
        int result = FileChooser.showSaveDialog(graphicsPanel);
        File file = FileChooser.getSelectedFile();
        if(file == null) {return;}
        path = file.getPath();
        dataPut.getPath(path);
        dataPut.put(PlaneSave,MandelbrotSave,ColorSave,MandelbrotXi,CurrentColorI); // Никитино
        // Если файл выбран, то представим его в сообщении
        if (result == JFileChooser.APPROVE_OPTION )
            JOptionPane.showMessageDialog(graphicsPanel,
                    "Файл (" + FileChooser.getSelectedFile() +
                            " ) сохранен");

    }
    public void setDataPut(Plane PlaneSave, MandelbrotX2 MandelbrotSave, ColorFunctionDark ColorSave)
    {
        this.PlaneSave = PlaneSave;
        this.MandelbrotSave = MandelbrotSave;
        this.ColorSave = ColorSave;



    }
    public void MandelbrotXi( Integer mandelbrotXi)
    {
        this.MandelbrotXi = mandelbrotXi;
    }
    public void CurrentColorI(Integer currentColorI)
    {
      this.CurrentColorI = currentColorI;
        System.out.println(CurrentColorI);
    }


}
