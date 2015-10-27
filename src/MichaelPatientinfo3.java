import javax.swing.JOptionPane;
import java.io.*;
import java.util.Scanner;

public class MichaelPatientinfo3 {
    public static void main(String[] args) throws FileNotFoundException {
        // define variables
        int age = 0;
        String agestr = "";
        String currentSymptoms = "";
        String currentMedication = "";
        String procedureCode = "";
        String procedureName = "";
        String paymentstr = "";
        String medicarePaymentstr = "";
        String patientName = "";
        int intProcedureCode = 0;

        PrintWriter outFile = new PrintWriter("patientinfo.txt"); // print to
                                                                  // patientinfo.txt

        JOptionPane
                .showMessageDialog(
                        null,
                        "This program asks the "
                                + "user for:\n a patient name,\n age,\n current symptoms,\n current medication(s),\n medical procedure CPT code,\n and the procedure name.\n The program determines the Medicaire payment.\n The information is then stored to a file for archival purposes.",
                        "Message", JOptionPane.INFORMATION_MESSAGE); // explains
                                                                     // what
                                                                     // this
                                                                     // program
                                                                     // does

        for (int i = 0; i < 5; i++) {

            // prompts for the user
            patientName = JOptionPane.showInputDialog("Please enter the patient's name.");
            agestr = JOptionPane.showInputDialog("Please enter the patient's age.");
            currentSymptoms = JOptionPane.showInputDialog("Please enter the patient's current symptoms." + " If none, type None.");
            currentMedication = JOptionPane.showInputDialog("Please enter the patient's current medication(s)." + " If none, type None.");
            procedureCode = JOptionPane.showInputDialog("Please enter the procedure code.");
            procedureName = JOptionPane.showInputDialog("Please enter the procedure name.");
            intProcedureCode = Integer.parseInt(procedureCode); // convert
                                                                // string to int

            // begin switch for payment
            switch (intProcedureCode) {
            case 10060:
                paymentstr = "79.71";
                break;
            case 21315:
                paymentstr = "130.81";
                break;
            case 21431:
                paymentstr = "654.17";
                break;
            case 21623:
                paymentstr = "712.72";
                break;
            case 21717:
                paymentstr = "742.37";
                break;
            case 21860:
                paymentstr = "777.77";
                break;
            case 21934:
                paymentstr = "801.11";
                break;
            case 30201:
                paymentstr = "834.23";
                break;
            case 31123:
                paymentstr = "845.67";
                break;
            case 32345:
                paymentstr = "868.641";
                break;
            default:
                paymentstr = "0";
                break;
            }

            age = Integer.parseInt(agestr); // convert string to int

            // print to outfile
            outFile.println("Patient Name: " + patientName);
            outFile.println("Patient's Age: " + age);
            outFile.println("Patient's Current Symptoms: " + currentSymptoms);
            outFile.println("Patient's Current Medication(s): " + currentMedication);
            outFile.println("Patient's Procedure Code: " + procedureCode);
            outFile.println("Patient's Procedure Name: " + procedureName);
            outFile.println("Patient's Medicare Payment: $" + paymentstr);
            outFile.flush();

            // show final message dialog box
            JOptionPane.showMessageDialog(null, "Thank you for entering the patient data. \n" + "The data has been saved in the file patientinfo.txt\n" + "Patient Name: " + patientName
                    + "\nPatient's Age: " + age + "\nPatient's Current Symptoms: " + currentSymptoms + "\nPatient's Current Medication(s): " + currentMedication + "\nPatient's Procedure Code: "
                    + procedureCode + "\nPatient's Procedure Name: " + procedureName + "\nPatient's Medicare Payment: $" + paymentstr, "Patient Information Complete", JOptionPane.INFORMATION_MESSAGE);
        }

        outFile.close(); // close outfile

        System.exit(0); // exit

    }
}