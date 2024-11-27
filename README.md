# OOP_Java_Project

# Medicare Management System
A comprehensive digital platform designed to streamline user registration, login, and healthcare data management for patients and doctors, facilitating improved healthcare services and communication.

📋 Objective


To develop a digital system that securely manages user accounts and healthcare data, fostering seamless interactions between patients and doctors while ensuring efficient record-keeping and prescription management.


✨ Key Features

🔑 User Management

  ⧠ Role-based Access: Supports registration and login for two user types: Doctors and Patients.

  ⧠ Secure Credentials: Usernames and passwords are securely stored, ensuring data privacy.

👨‍⚕️ Doctor Module

  ⧠ Register and log in as a doctor.

  ⧠ Add, view, and update patient information.

  ⧠ Prescribe medicines and manage patient health details.

👩‍⚕️ Patient Module

  ⧠ Register and log in as a patient.

  ⧠ View and update personal details and health conditions.

  ⧠ Access prescribed medicines and health updates.

💾 Data Storage

  ⧠ Data persistence is ensured using external text files (users.txt and patients.txt).

  ⧠ Dynamic management of patient health data and prescriptions.


🛠️ Core Classes

Class	Description

Person:	Abstract class representing common attributes (name, age) shared by both Doctors and Patients.

Doctor:	Inherits from Person, adds a specialty attribute, and manages patient details and prescriptions.

Patient:	Inherits from Person, includes health condition and prescribed medicines.

Medicine:	Represents medicine details such as name and dosage.


🧑‍💻 Core Principles of OOP

This project effectively demonstrates the four core principles of Object-Oriented Programming (OOP):


🔒 Encapsulation

  ⧠ Each class encapsulates relevant data and behavior.

  ⧠ Private/protected attributes (e.g., healthCondition in Patient) are accessed through getter and setter methods, ensuring controlled data access.

🧬 Inheritance

  ⧠ Doctor and Patient classes inherit from the Person class, promoting reusability and reducing code duplication.

  ⧠ Common methods (e.g., showPersonDetails()) are shared while allowing for specialized extensions in subclasses.

🔄 Polymorphism

  ⧠ The showPersonDetails() method is overridden in the Doctor and Patient classes, enabling different behavior depending on the object type.

  ⧠ This showcases runtime polymorphism, allowing flexible and dynamic method execution.

🧩 Abstraction

  ⧠ The Medicare class abstracts complex operations like user registration, login, and data handling.

  ⧠ Users interact with high-level functions (register(), login()) without needing to know internal implementation details.


🌍 Sustainable Development Goals (SDGs)

This project aligns with the following United Nations Sustainable Development Goals:


SDG 3: Good Health and Well-being

  ⧠ Promotes better access to healthcare services through a digital platform that tracks patient health conditions and prescriptions.

SDG 9: Industry, Innovation, and Infrastructure

  ⧠ Fosters innovation in healthcare technology by developing a digital infrastructure for patient records and prescriptions.


🚀 Benefits

  ⧠ Enhanced Healthcare Management: Secure and organized handling of patient data and medical records.

  ⧠ Improved Communication: Facilitates seamless interactions between doctors and patients.

  ⧠ Efficient Service Delivery: Supports better decision-making and healthcare service delivery.


📂 Data Files

  ⧠ users.txt: Stores user credentials for login.

  ⧠ patients.txt: Stores patient health details and prescribed medicines.


💻 How to Use

  ① Register: Create an account as a doctor or patient.

  ② Login: Access the system using secure credentials.

  ③ Manage Data

    ⧠ Doctors: Add and update patient records, prescribe medicines.

    ⧠ Patients: View and update personal health details and prescriptions.


🛡️ Security Measures

  ⧠ Credentials are securely managed using encryption methods (if implemented).
  
  ⧠ Data persistence ensures information is retained across sessions.


🔧 Future Enhancements

  ⧠ Integration of database systems (e.g., SQL) for scalable data management.

  ⧠ Implementation of a GUI for better user experience.

  ⧠ Support for appointment scheduling and notifications.


🤝 Contributions

Contributions are welcome! Feel free to fork the repository and submit pull requests.
