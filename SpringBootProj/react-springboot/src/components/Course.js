import React, { Component } from "react";
import {
  Card,
  CardBody,
  CardTitle,
  CardSubtitle,
  CardText,
  CardFooter,
  Button,
  Container,
} from "reactstrap";
import { ToastContainer, toast } from "react-toastify";
import { Form, FormGroup, Label, Input, FormText } from "reactstrap";
import axios from "axios";

class Course extends Component {
  constructor(props) {
    super(props);
    // const course = props.course;

    const refreshParent = this.props.refreshParent;

    this.state = {
      courseid: props.course.courseid,
      coursetitle: props.course.coursetitle,
      coursedesc: props.course.coursedesc,
      mode: "view",
    };
  }

  openUpdate1 = () => {
    //alert("here:" + this.state.mode);
    this.setState({ mode: "update" });
    //alert("here updated mode:" + this.state.mode);
  };

  UpdateCourse = () => {
    //alert("Course updating.." + this.state.courseid);
    axios
      .post("http://localhost:8081/updatecourse", {
        courseid: this.state.courseid,
        coursetitle: this.state.coursetitle,
        coursedesc: this.state.coursedesc,
      })
      .then(
        (response) => {
          console.log("Here is success..");
          console.log(response.data);
          toast.success(response.data);
          this.props.refreshParent();
        },
        (error) => {
          console.log("Here is error..");
          console.log(error);
        }
      );
  };

  openCancel = () => {
    this.setState({ mode: "view" });
  };

  handleChange(event) {
    this.setState({ [event.target.name]: event.target.value });
    // alert(event.target.name);
  }

  render() {
    const course = this.props.course;
    const deletecourse = this.props.deletecourse;
    const openUpdate = this.props.openUpdate;

    if (this.state.mode == "view") {
      return (
        <Card className="text-center" id={course.courseid}>
          <CardBody>
            <CardSubtitle>
              <h2>{course.coursetitle}</h2>
            </CardSubtitle>
            <CardText>{course.coursedesc}</CardText>
            <Container>
              <Button
                color="danger"
                onClick={() => deletecourse(course.courseid)}
              >
                Delete
              </Button>
              <Button
                color="warning ml-3"
                onClick={() => this.openUpdate1(course.courseid)}
              >
                Update
              </Button>
            </Container>
          </CardBody>
        </Card>
      );
    } else {
      return (
        <div style={{ border: "2px solid red" }}>
          <ToastContainer />
          <h3>Update Course</h3>
          <form>
            <FormGroup>
              <label for="courseid">Course ID</label>
              <Input
                type="text"
                name="courseid"
                id="courseid"
                value={this.state.courseid}
                placeholder="Enter the ID of new course"
                onChange={this.handleChange.bind(this)}
                readOnly
              />
            </FormGroup>
            <FormGroup>
              <label for="coursetitle">Course Title</label>
              <Input
                type="text"
                name="coursetitle"
                id="coursetitle"
                value={this.state.coursetitle}
                placeholder="Enter the title of new course"
                onChange={this.handleChange.bind(this)}
                required
              />
            </FormGroup>
            <FormGroup>
              <label for="coursedesc">Course Details</label>
              <Input
                type="textarea"
                name="coursedesc"
                id="coursedesc"
                value={this.state.coursedesc}
                placeholder="Eneter the description of the course"
                onChange={this.handleChange.bind(this)}
              />
            </FormGroup>
            <Button color="success" onClick={this.UpdateCourse}>
              UPDATE
            </Button>
            <Button
              color="warning ml-2"
              onClick={() => this.openCancel(course.courseid)}
            >
              CANCEL
            </Button>
          </form>
        </div>
      );
    }
  }
}

export default Course;
