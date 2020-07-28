import React, { useState } from "react";
import Course from "./Course";

const AllCourses = () => {
  const [courses, setCourses] = useState([
    {
      title: "Java Course",
      description: "This is a SpringBoot course for beginners",
    },
    {
      title: "Linux Course",
      description: "This is a Linux Admin course for beginners",
    },
    {
      title: "ServiceNow Course",
      description: "This is a SNOW Admin course for beginners",
    },
  ]);

  return (
    <div>
      {courses.length > 0
        ? courses.map((item) => <Course course={item} />)
        : "No Course available"}
    </div>
  );
};

export default AllCourses;
