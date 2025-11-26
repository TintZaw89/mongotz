import React from 'react';
import './App.css';
import FetchData from './component/FetchData.jsx';
import {BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import HeaderComponent from './component/HeaderComponent';
import FooterComponent from './component/FooterComponent';
import ConfigMovieComponent from './component/ConfigMovieComponent.jsx';

function App() {
  return (
    <div>
    <Router>
        <HeaderComponent />
        
        <div className= "container">
            <Routes>
              <Route path = "/imdbmovie" element = {<FetchData />} />
              <Route path = "/add-imdbmovie" element = {<FetchData />} />
              <Route path = "/edit-imdbmovie/:id" element = {<ConfigMovieComponent />} />
              <Route exact path = "/" element = {<FetchData />} />
            </Routes>
        </div>
        <FooterComponent />
    </Router>
    </div>
  );
}

export default App
