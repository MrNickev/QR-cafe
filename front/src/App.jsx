import './App.css';
import {BrowserRouter, Route, Router, Routes} from "react-router-dom";
import React from "react";
import Login from "./pages/auth/login";
import Navbar from "./pages/navbar/navbar";
import Layout from "./components/layout/layout";
import Registration from "./pages/auth/registration";

function App() {
  return (
    <div className="App">
        <BrowserRouter>
          <Routes>
            <Route path="/sign-in" element={<Login />} />
            <Route path="/sign-up" element={<Registration />} />
              <Route path="/layout" element={<Layout />} >
                  <Route index element={<Navbar />} />
                  {/*<Route path="tables" element={<Tables />} />*/}
                  {/*<Route path="waiters" element={<Waiters />} />*/}
                  {/*<Route path="menu" element={<Menu />} />*/}
                  {/*<Route path="feedbacks" element={<Feedbacks />} />*/}
              </Route>


          </Routes>
        </BrowserRouter>
    </div>
  );
}

export default App;
