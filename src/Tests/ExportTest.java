package Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import java.io.*;
import Classes.Character;
import Classes.Export;

/**
 * Created by Mason Millsap on 4/10/2017.
 */
public class ExportTest {

    Export export = new Export(new Character("Test"));

    @Test
    public void writeSkillsTest() throws IOException {
        File file = new File("resources/Test.txt");
        FileWriter fw = new FileWriter(file);
        BufferedReader br = new BufferedReader( new FileReader(file));
        try {
            export.writeSkills(fw);
            fw.close();
            assertEquals("SKILLS", br.readLine());

        } catch (IOException e) {
            System.out.println("Failed try");
            e.printStackTrace();
        }
    }
    @Test
    public void writeAttributesTest() throws IOException {
        File file = new File("resources/Test.txt");
        FileWriter fw = new FileWriter(file);
        BufferedReader br = new BufferedReader( new FileReader(file));
        try {
            export.writeAttributes(fw);
            fw.close();
            assertEquals("ATTRIBUTES", br.readLine());

        } catch (IOException e) {
            System.out.println("Failed try");
            e.printStackTrace();
        }
    }
    @Test
    public void writeStatisticsTest() throws IOException {
        File file = new File("resources/Test.txt");
        FileWriter fw = new FileWriter(file);
        BufferedReader br = new BufferedReader( new FileReader(file));
        try {
            export.writeStatistics(fw);
            fw.close();
            assertEquals("STATISTICS", br.readLine());

        } catch (IOException e) {
            System.out.println("Failed try");
            e.printStackTrace();
        }
    }
    @Test
    public void writeMiscTest() throws IOException {
        File file = new File("resources/Test.txt");
        FileWriter fw = new FileWriter(file);
        BufferedReader br = new BufferedReader( new FileReader(file));
        try {
            export.writeMisc(fw);
            fw.close();
            assertEquals("MISCELLANEOUS", br.readLine());

        } catch (IOException e) {
            System.out.println("Failed try");
            e.printStackTrace();
        }
    }
}
