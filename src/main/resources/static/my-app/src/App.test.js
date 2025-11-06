import { render, screen } from '@testing-library/react';
import App from './App';
//import React,{useEffect, useState} from 'react';
//import axios from 'axios';
test('renders learn react link', () => {
  render(<App />);
  const linkElement = screen.getByText(/learn react/i);
  expect(linkElement).toBeInTheDocument();
  /*useEffect((query) => {
      axios.get(`${BASE_URL}${encodeURIComponent(query)}`)
          .then(res => setData(res.data))
      .catch(err => console.log(err));
    }, []) */
});
