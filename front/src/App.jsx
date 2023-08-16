import './App.css';
import {BrowserRouter, Route, Router, Routes} from "react-router-dom";
import React from "react";
import Login from "./pages/auth/login";
import Navbar from "./pages/navbar/navbar";
import Layout from "./components/layout/layout";

function App() {
  return (
    <div className="App">
        <BrowserRouter>
          <Routes>
            <Route path="/login" element={<Login />} />
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
