import React from "react";
import { AppBar, Toolbar, Box, Grid, Typography, Button } from "@mui/material";
import { useNavigate } from "react-router-dom";

const Navbar = () => {
  const navigate = useNavigate();

  return (
    <div>
      <Grid container spacing={2} sx={{ margin: "2%" }}>
        <Box sx={{ flexGrow: 1 }}>
          <AppBar position="static" style={{ background: "#ADD8E6" }}>
            <Toolbar variant="dense">
              <Typography
                variant="h4"
                align="left"
                component="div"
                sx={{
                  flexGrow: 1,
                  fontFamily: "revert",
                  fontSize: "500",
                  color: "black",
                }}
              >
                Job Portal
              </Typography>

              <Box sx={{ m: 0.5, mx: "auto", width: 80 }}>
                <Button variant="outlined" onClick={() => navigate("/")}>
                  Home
                </Button>
              </Box>
              <Box sx={{ m: 0.5, mx: "auto", width: 100 }}>
                <Button variant="outlined" onClick={() => navigate("/create")}>
                  Add Job
                </Button>
              </Box>
              <Box sx={{ m: 0.5, mx: "auto", width: 180 }}>
                <Button
                  variant="outlined"
                  onClick={() => window.open("https://www.youtube.com/", "_blank")}
                >
                  Contact Us
                </Button>
              </Box>
            </Toolbar>
          </AppBar>
        </Box>
      </Grid>
      <Grid item xs={12} md={12} lg={12}></Grid>
    </div>
  );
};

export default Navbar;
