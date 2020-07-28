import React from "react";
import { ListGroup, ListGroupItem } from "reactstrap";
import { BrowserRouter as Router, Route, Link } from "react-router-dom";

const Menus = () => {
  return (
    <div>
      <ListGroup>
        <Link
          className="list-group-item list-group-item-action"
          color="warning"
          tag="a"
          to="/"
        >
          Home
        </Link>
        <Link
          className="list-group-item list-group-item-action"
          color="warning"
          tag="a"
          to="/AllCourses"
        >
          View Course Details
        </Link>
        <Link
          className="list-group-item list-group-item-action"
          color="warning"
          tag="a"
          to="/AddCourse"
        >
          Add Courses
        </Link>
        <Link
          className="list-group-item list-group-item-action"
          color="warning"
        >
          About Us
        </Link>
      </ListGroup>
    </div>
  );
};

export default Menus;
