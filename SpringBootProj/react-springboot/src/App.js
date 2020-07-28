import React from "react";
import {
  Card,
  CardImg,
  CardText,
  CardBody,
  CardTitle,
  CardSubtitle,
  Button,
  Row,
  Container,
  Col,
} from "reactstrap";

import { ToastContainer, toast } from "react-toastify";
import "react-toastify/dist/ReactToastify.css";

import "./App.css";
import Header from "./components/Header";
import Home from "./components/Home";
import Course from "./components/Course";
import AllCoursesClass from "./components/AllCoursesClass";
import AddCourse from "./components/AddCourse";
import Menus from "./components/Menus";
import { BrowserRouter as Router, Route } from "react-router-dom";
import UpdateCourse from "./components/UpdateCourse";

function App() {
  const notify = () =>
    toast.info("Wow so easy !", {
      position: "top-center",
    });

  return (
    <div className="text-center">
      <Container>
        <Router>
          <ToastContainer />
          <Header />
          <Container>
            <Row>
              <Col md={4}>
                <Menus />
              </Col>
              <Col md={8}>
                <Route path="/" component={Home} exact />
                <Route path="/AllCourses" component={AllCoursesClass} exact />
                <Route path="/AddCourse" component={AddCourse} exact />
                <Route path="/UpdateCourse" component={UpdateCourse} exact />
              </Col>
            </Row>
          </Container>
        </Router>
      </Container>
    </div>
  );
}

export default App;
