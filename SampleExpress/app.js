const express = require("express");
const mongoose = require("mongoose");
const app = express();
// Connect to MongoDB
mongoose
    .connect(
        "mongodb+srv://viishhnu:kmit26@cluster0.ilbf4.mongodb.net/Student?retryWrites=true&w=majority&appName=Cluster0",
        {
            useNewUrlParser: true,
            useUnifiedTopology: true,
        }
    )
    .then(() => console.log("Connected to MongoDB"))
    .catch((err) => console.error("MongoDB connection error:", err));
// Define Student Schema
const studentSchema = new mongoose.Schema({
    name: String,
    rollNo: String,
    scores: {
        Java: Number,
        CPP: Number,
        Python: Number,
        GenAI: Number,
        FSD: Number,
    },
});
// Create Student Model
const Student = mongoose.model("Student", studentSchema);
// Middleware
app.use(express.json());
// Route to fetch student data by roll number
// app.get("/student/:rollNo", async (req, res) => {
//     const rollNo = req.params.rollNo;
//     try {
//         const student = await Student.findOne({ rollNo }, { _id: 0 });
//         if (student) {
//             res.status(200).json(student);
//         } else {
//             res.status(404).json({ message: "Student not found" });
//         }
//     } catch (err) {
//         res.status(500).json({
//             message: "Error fetching student data",
//             error: err,
//         });
//     }
// });
// Route to insert a new student document
app.post("/student",async (req,res)=>{
    try{
        const student = new Student(req.body);
        await student.save();
        res.status(201).json({message : "Student added successfully",student});
    }
    catch(err){
        res.status(400).json({ message: "Failed to add student", error: err });
    }
});

// Delete a Student
app.delete("/student/:rollNo", async (req, res) => {
    const rollNo = req.params.rollNo;
    try {
        const deletedStudent = await Student.findOneAndDelete({ rollNo });
        if (deletedStudent) {
            res.status(200).json({ message: "Student deleted successfully", deletedStudent });
        } else {
            res.status(404).json({ message: "Student not found" });
        }
    } catch (err) {
        res.status(500).json({ message: "Failed to delete student", error: err });
    }
});

// Update a student 
app.put("/student/:rollNo", async (req, res) => {
    const rollNo = req.params.rollNo;
    try {
        const updatedStudent = await Student.findOneAndUpdate(
            { rollNo },
            { $set: req.body },
            { new: true }
        );
        if (updatedStudent) {
            res.status(200).json({ message: "Student updated successfully", updatedStudent });
        } else {
            res.status(404).json({ message: "Student not found" });
        }
    } catch (err) {
        res.status(400).json({ message: "Failed to update student", error: err });
    }
});

app.get("/students", async (req, res) => {
    try {
        const students = await Student.find({}, { name: 1, rollNo: 1, scores: 1 });
        const studentsWithGPA = students.map((student) => {
            const { Java, CPP, Python, GenAI, FSD } = student.scores;
            const gpa = ((Java + CPP + Python + GenAI + FSD) / 5).toFixed(2);
            return {
                name: student.name,
                rollNo: student.rollNo,
                gpa,
            };
        });
        res.status(200).json(studentsWithGPA);
    } catch (err) {
        res.status(500).json({ message: "Failed to fetch students", error: err });
    }
}); 
// Start the server
const PORT = 3000;
app.listen(PORT, () => {
    console.log(`Server running on http://localhost:${PORT}`);
});
