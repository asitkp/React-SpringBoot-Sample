import React, { Component } from "react";
import PropTypes from "prop-types";
import Course from "./Course";
import axios from "axios";
import { ToastContainer, toast } from "react-toastify";

export class AllCoursesClass extends Component {
  constructor(props) {
    super(props);

    this.state = {
      courses: [],
    };
  }

  openUpdate = (cid) => {
    alert("called for update at parent.." + cid);
    //e.preventDefault();
    window.location.href = "/UpdateCourse";
  };

  deletecourse = (crsid) => {
    //alert("Delete course at parent.." + crsid);
    axios
      .post("http://localhost:8081/deletecourse", {
        courseid: crsid,
      })
      .then(
        (response) => {
          console.log("Here is success..");
          console.log(response.data);
          toast.success(response.data);
          this.componentDidMount();
        },
        (error) => {
          console.log("Here is error..");
          console.log(error);
        }
      );
  };

  refreshParent = () => {
    this.componentDidMount();
  };
  componentDidMount() {
    axios.get(`http://localhost:8081/getallcourses`).then((res) => {
      const courses1 = res.data.map((obj) => obj.data);
      console.log(courses1);
      this.setState({ courses: res.data });
    });
  }

  render() {
    return (
      <div>
        {this.state.courses.map((item) => (
          <Course
            course={item}
            deletecourse={this.deletecourse}
            openUpdate={this.openUpdate}
            refreshParent={this.refreshParent}
          />
        ))}
      </div>
    );
  }
}

export default AllCoursesClass;
