import React, { useEffect, useState } from "react";
import {
  Box,
  Card,
  Container,
  Grid,
  TextField,
  Typography,
  InputAdornment,
} from "@mui/material";
import SearchIcon from "@mui/icons-material/Search";
import DeleteIcon from "@mui/icons-material/Delete";
import EditIcon from "@mui/icons-material/Edit";
import axios from "axios";
import { useNavigate } from "react-router-dom";

const Search = () => {
  const [post, setPost] = useState([]);
  const [queryText, setQueryText] = useState("");
  const navigate = useNavigate();

  useEffect(() => {
    const delayDebounce = setTimeout(() => {
      const fetchPosts = async () => {
        try {
          const url =
            queryText.length > 2
              ? `http://localhost:8080/jobPosts/keyword/${queryText}`
              : `http://localhost:8080/jobPosts`;
          const response = await axios.get(url);
          setPost(response.data);
        } catch (error) {
          console.error("Error fetching posts:", error);
        }
      };

      fetchPosts();
    }, 300); // 300ms debounce

    return () => clearTimeout(delayDebounce);
  }, [queryText]);

  const handleDelete = async (id) => {
    await axios.delete(`http://localhost:8080/jobPost/${id}`);
    setPost((prev) => prev.filter((p) => p.postId !== id));
  };

  const handleEdit = (id) => {
    navigate("/edit", { state: { id } });
  };

  return (
    <Container sx={{ mt: 4 }}>
      <Box sx={{ mb: 4 }}>
        <TextField
          fullWidth
          variant="outlined"
          placeholder="Search..."
          value={queryText}
          onChange={(e) => setQueryText(e.target.value)}
          InputProps={{
            startAdornment: (
              <InputAdornment position="start">
                <SearchIcon />
              </InputAdornment>
            ),
          }}
        />
      </Box>

      <Grid container spacing={3}>
        {post.length === 0 ? (
          <Typography variant="h6" sx={{ margin: "auto" }}>
            No job posts found.
          </Typography>
        ) : (
          post.map((p) => (
            <Grid key={p.postId} item xs={12} sm={6} md={4}>
              <Card sx={{ p: 3, backgroundColor: "#f0f8ff", boxShadow: 3 }}>
                <Typography variant="h6">{p.postProfile}</Typography>
                <Typography>Description: {p.postDesc}</Typography>
                <Typography>Experience: {p.reqExperience} years</Typography>
                <Typography>Skills:</Typography>
                {p.postTechStack?.map((s, i) => (
                  <Typography key={i}>{s}</Typography>
                ))}
                <Box sx={{ mt: 2 }}>
                  <DeleteIcon
                    onClick={() => handleDelete(p.postId)}
                    sx={{ cursor: "pointer", mr: 1 }}
                  />
                  <EditIcon
                    onClick={() => handleEdit(p.postId)}
                    sx={{ cursor: "pointer" }}
                  />
                </Box>
              </Card>
            </Grid>
          ))
        )}
      </Grid>
    </Container>
  );
};

export default Search;
