import React from "react";
import ReactDOM from "react-dom/client";
import "./index.css";

import {
  createBrowserRouter,
  createRoutesFromElements,
  Route,
  RouterProvider,
} from "react-router-dom";
import Router from "./Router";
import AllPosts from "./components/AllPosts";
import Create from "./components/Create";
import Edit from "./components/Edit";
import Search from "./components/AllPosts";

const router = createBrowserRouter(
  createRoutesFromElements(
    <Route path="/" element={<Router />}>
      <Route index element={<Search />} />
      <Route path="search" element={<Search />} /> {/* ✅ Add this */}
      <Route path="create" element={<Create />} />
      <Route path="edit" element={<Edit />} />
    </Route>
  )
);

const root = ReactDOM.createRoot(document.getElementById("root"));
root.render(<RouterProvider router={router} />);
