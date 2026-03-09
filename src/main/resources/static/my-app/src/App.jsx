//import React from 'react';
import './App.css';
import FetchData from './component/FetchData.jsx';
import AfterUpdate from './component/AfterUpdate.jsx';
import {BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import HeaderComponent from './component/HeaderComponent';
import FooterComponent from './component/FooterComponent';
import ConfigMovieComponent from './component/ConfigMovieComponent.jsx';
import ErrorBoundary from './component/ErrorBoundary';
import ErrorFallback from './component/ErrorFallback';
import Home from './component/Home.jsx';

function App() {
  return (
    <div>
    <Router>
      <ErrorBoundary fallbackComponent={ErrorFallback}>
        <HeaderComponent />
        
        <div className= "container">
            <Routes>
              <Route path = '/home' element={<Home />}/>
              <Route path = "/imdbmovie" element = {<FetchData />} />
              <Route path = "/add-imdbmovie" element = {<FetchData />} />
              <Route path = "/edit-imdbmovie/:id" element = {<ConfigMovieComponent />} />
              <Route path = "/imdbmovieid" element = {<AfterUpdate />} />
              <Route exact path = "/" element={<FetchData />} />
            </Routes>
        </div>
        <FooterComponent />
     </ErrorBoundary>
    </Router>
    </div>
  );
}

export default App
