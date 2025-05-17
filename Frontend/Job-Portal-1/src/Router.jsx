import React from "react";
//import Navbar from "./components/Navbar";
import Navbar from "./components/Navbar";
import { Outlet } from "react-router-dom";

function Router() {
  return (
    <>
      <Navbar />
      <Outlet />
    </>
  );
}
export default Router;
