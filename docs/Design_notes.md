# Design Notes

## Why ArrayList instead of Array?
ArrayList is dynamic — no need to define size upfront unlike arrays.
Since the number of students, courses and enrollments is not known
in advance, ArrayList is the better choice as it grows automatically
as data is added.

## Where and why Static members?
Static members were used in IdGenerator — studentIdCounter,
courseIdCounter and enrollmentIdCounter are static because they
belong to the class, not to any object. This ensures one single
counter is shared across the entire application, guaranteeing
unique IDs every time.

InputValidator methods are also static since they are utility
methods that don't need any object state to work.

## Where and why Inheritance?
Student extends Person. Student inherits id, firstName, lastName
and email from Person without repeating those fields.

Benefit — code reuse. Common fields and methods are defined once
in Person and reused in Student. getDisplayName() is overridden
in Student to show batch info — demonstrating polymorphism too.