# OOP_Java_Project

Project Name: Medicare Management System

Objective: 
To create a Digital System that manages user registration, login, and healthcare data for patients and doctors, facilitating better healthcare management.

# The Key Features of this Project:
User Management: 
 * Allows registration and login for two types of users, Doctors and Patients. 
 * User credentials (username and password) are securely stored.
Doctor Module:
 * Register and log in as a doctor.
 * Add new patients and manage patient information.
 * Prescribe medicines to patients.
 * View and update patient health details.
Patient Module:
 * Register and log in as a patient.
 * View and update personal details and health conditions.
 * View prescribed medicines.
Data Storage:
 * Patient and user data are stored in external text files (users.txt and patients.txt), ensuring persistence across sessions.
 * Patient health data and prescriptions are dynamically managed.
  
Core Classes:
  Person: A base class representing common attributes (name, age) shared by both Patients and Doctors.
  Doctor: Inherits from Person, adds a specialty, and allows interaction with patient records.
  Patient: Inherits from Person, includes health condition and prescribed medicines.
  Medicine: Represents medicine details (name, dosage) prescribed to patients.

Benefits:
 * Facilitates secure and organized management of healthcare data.
 * Promotes seamless communication between doctors and patients.
 * Improves healthcare service delivery through efficient record-keeping and prescription management.

# 4 Core Principles of OOP
The Project Medicare demonstrates the core OOP principles to manage users and healthcare data effectively.

Encapsulation:
  In the code, each class (e.g., Person, Patient, Doctor, Medicine) encapsulates its relevant data (e.g., name, age, health condition, specialty) and behavior (e.g., showPersonDetails(), prescribeMedicine()).
  Private or protected attributes (like healthCondition in Patient) are accessed or modified through getter and setter methods, ensuring controlled data access and modification.
Inheritance:
  The Patient and Doctor classes inherit from the Person class. This inheritance allows both Patient and Doctor to use the common attributes (name, age) and methods (getName(), showPersonDetails()) defined in the     Person class.
  This prevents duplication of common code and promotes reusability. The Patient class extends its functionality with attributes like healthCondition and prescriptions, while the Doctor class adds specialty.
Polymorphism:
  The showPersonDetails() method in the Person class is overridden in the Patient and Doctor classes. While both subclasses inherit this method, each implements it differently to show specific details (e.g., a        doctor's specialty or a patient's health condition).
  This method overriding allows the same method name to function differently depending on the object type, showcasing runtime polymorphism.
Abstraction:
  The Medicare class abstracts the internal complexities of user registration, login, and data management. From the user's perspective, they only interact with high-level functions like register() or login(),         while the underlying implementation (e.g., file handling) is hidden.
  Users interact with objects (e.g., Doctor, Patient) without needing to know how the internal methods work or how data is stored and retrieved, promoting simplicity and focus on the essential features.

# Sustainable Development Goals
The Medicare Management System addresses multiple Sustainable Development Goals (SDGs) through the development of a healthcare-related system.

SDG 3: Good Health and Well-being - 
      The program creates a digital health management system for patients and doctors, focusing on health conditions and prescriptions. This directly supports SDG 3 by promoting better access to health services         and ensuring patients receive proper medical care.
SDG 9: Industry, Innovation, and Infrastructure - The development of a digital infrastructure to manage patient records and prescriptions aligns with SDG 9, fostering innovation in healthcare technology.

