import React from "react";
import "./App.css";
import { BrowserRouter as Router, Route, Switch } from "react-router-dom";
import ListEmployeeComponent from "./components/ListEmployeeComponent";
import HeaderComponent from "./components/HeaderComponent";
import FooterComponent from "./components/FooterComponent";
import CreateEmployeeComponent from "./components/CreateEmployeeComponent";
import UpdateEmployeeComponent from "./components/UpdateEmployeeComponent";
import ViewEmployeeComponent from "./components/viewEmployeeComponent";

function App() {
  return (
    <div>
      <Router>
        <div className="container">
          <HeaderComponent />
          <div className="container">
            <Switch>
              {/* http://localhost:3000/, http://localhost:3000/employees */}
              <Route path="/" exact component={ListEmployeeComponent}></Route>
              <Route path="/employees" component={ListEmployeeComponent}></Route>
              {/* localhost:3000/add-employee */}
               {/* step 1 */}
              <Route path="/add-employee/:id" component={CreateEmployeeComponent}></Route>
              {/* localhost:3000/update-employee/1 */}
              {/* <Route path="/update-employee/:id" component={UpdateEmployeeComponent}></Route> */}
              <Route path="/view-employee/:id" component={ViewEmployeeComponent}></Route>
              <ListEmployeeComponent />
            </Switch>
          </div>
          <FooterComponent />
        </div>
      </Router>
    </div>
  );
}

export default App;
