import React, { Component } from "react";
import { Button, Form, FormGroup, Label, Input, FormText } from "reactstrap";
import axios from "axios";
import { ToastContainer, toast } from "react-toastify";

class AddCourse extends Component {
  constructor(props) {
    super(props);

    this.state = {
      courseid: "",
      coursetitle: "",
      coursedesc: "",
    };
  }

  handleChange(event) {
    this.setState({ [event.target.name]: event.target.value });
    // alert(event.target.name);
  }

  calledMethod = () => {
    //alert("Method called..");

    axios
      .post("http://localhost:8081/addcourse", {
        coursetitle: this.state.coursetitle,
        coursedesc: this.state.coursedesc,
        courseid: this.state.courseid,
      })
      .then(
        (response) => {
          console.log("Here is success..");
          console.log(response.data);
          toast.success(response.data);
          this.setState({
            coursetitle: "",
            coursedesc: "",
            courseid: "",
          });
        },
        (error) => {
          console.log("Here is error..");
          console.log(error);
        }
      );
  };

  render() {
    return (
      <div>
        <ToastContainer />
        <h3>Add New Course</h3>
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
              required
            />
          </FormGroup>
          <FormGroup>
            <label for="coursetitle">Course Titleee</label>
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
              placeholder="Eneter the description of new course"
              onChange={this.handleChange.bind(this)}
            />
          </FormGroup>
          <Button color="success" onClick={this.calledMethod}>
            SUBMIT
          </Button>
          <Button color="warning ml-2">CLEAR</Button>
        </form>
      </div>
    );
  }
}

export default AddCourse;
