package generics;
import java.util.ArrayList;
import java.util.List;

abstract class JobRole {
    abstract String getRoleName();
}

class SoftwareEngineer extends JobRole {
    @Override
    String getRoleName() {
        return "Software Engineer";
    }
}

class DataScientist extends JobRole {
    @Override
    String getRoleName() {
        return "Data Scientist";
    }
}

class ProductManager extends JobRole {
    @Override
    String getRoleName() {
        return "Product Manager";
    }
}

class Resume<T extends JobRole> {
    private String candidateName;
    private T targetRole;

    public Resume(String candidateName, T targetRole) {
        this.candidateName = candidateName;
        this.targetRole = targetRole;
    }

    public String getCandidateName() {
        return candidateName;
    }

    public T getTargetRole() {
        return targetRole;
    }

    public void display() {
        System.out.println("Candidate: " + candidateName + ", Applying for: " + targetRole.getRoleName());
    }
}

public class ResumeScreeningSystem {

    public static <T extends JobRole> boolean screenResume(Resume<T> resume) {
        System.out.println("Screening " + resume.getCandidateName() + " for " + resume.getTargetRole().getRoleName() + "...");
        boolean isFit = resume.getCandidateName().length() > 3;
        System.out.println("-> Result: " + (isFit ? "Good Fit" : "Not a Fit"));
        return isFit;
    }
    
    public static void processScreeningPipeline(List<Resume<? extends JobRole>> resumes) {
        System.out.println("\n--- Processing Full Resume Screening Pipeline ---");
        for (Resume<? extends JobRole> resume : resumes) {
            screenResume(resume);
        }
        System.out.println("--- Pipeline Processing Complete ---");
    }

    public static void main(String[] args) {
        SoftwareEngineer seRole = new SoftwareEngineer();
        DataScientist dsRole = new DataScientist();
        
        Resume<SoftwareEngineer> resume1 = new Resume<>("Alice", seRole);
        Resume<DataScientist> resume2 = new Resume<>("Bob", dsRole);
        Resume<SoftwareEngineer> resume3 = new Resume<>("Charlie", seRole);
        
        List<Resume<? extends JobRole>> screeningPipeline = new ArrayList<>();
        screeningPipeline.add(resume1);
        screeningPipeline.add(resume2);
        screeningPipeline.add(resume3);
        
        screenResume(resume1);
        
        processScreeningPipeline(screeningPipeline);
    }
}