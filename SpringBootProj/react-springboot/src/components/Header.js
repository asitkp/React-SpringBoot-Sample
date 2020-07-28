import React from "react";
import { Jumbotron, Container } from "reactstrap";

function Header() {
  return (
    <Jumbotron className="text-center" style={{ backgroundColor: "#ad9384" }}>
      <h1>Welcome to React-SpringBoot Application....</h1>
      This is a Test application used to learn how to create Spring-Boot
      application as back end and React as front end
    </Jumbotron>
  );
}

export default Header;
