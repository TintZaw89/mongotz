import React from 'react';
import './App.css';
import FetchData from './FetchData';
import {BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import HeaderComponent from './HeaderComponent';
import FooterComponent from './FooterComponent';
import ConfigMovieComponent from './ConfigMovieComponent.js';

function App() {
  return (
    <Router>
        <HeaderComponent />
        
        <div className= "container">
            <Routes>
              <Route exact path = "/" element = {<FetchData />} />
              <Route path = "/imdbmovie" element = {<FetchData />} />
              <Route path = "/add-imdbmovie" element = {FetchData} ></Route>
              <Route path = "/edit-imdbmovie/:id" element = {<ConfigMovieComponent />} />
            </Routes>
        </div>
        <FooterComponent />
        </Router>
  );
}

export default App
