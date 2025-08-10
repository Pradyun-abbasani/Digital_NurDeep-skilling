import React from "react";
import BookDetails from "./components/BookDetails";
import BlogDetails from "./components/BlogDetails";
import CourseDetails from "./components/CourseDetails";

function App() {
  const courses = [
    { name: "Angular", date: "4/5/2021" },
    { name: "React", date: "6/3/20201" },
  ];

  const books = [
    { id: 1, bname: "Master React", price: 670 },
    { id: 2, bname: "Deep Dive into Angular 11", price: 800 },
    { id: 3, bname: "Mongo Essentials", price: 450 },
  ];

  const blogs = [
    { title: "React Learning", author: "Stephen Biz", content: "Welcome to learning React!" },
    { title: "Installation", author: "Schwezdenier", content: "You can install React from npm." },
  ];

  return (
    <div style={{ display: "flex", justifyContent: "space-around", padding: "30px" }}>
      <CourseDetails courses={courses} />
      <div style={{ borderLeft: "3px solid green", height: "100px" }}></div>
      <BookDetails books={books} />
      <div style={{ borderLeft: "3px solid green", height: "100px" }}></div>
      <BlogDetails blogs={blogs} />
    </div>
  );
}

export default App;
