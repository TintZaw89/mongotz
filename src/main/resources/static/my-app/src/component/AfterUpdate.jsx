import React, {useState, useEffect} from 'react'
import {useLocation} from 'react-router-dom';
import MovieTable from './MovieTable';
import MovieService from './MovieService';
import { Link } from 'react-router-dom';
const AfterUpdate = () => {
  // ... (useState and useEffect code from above) ...
const location = useLocation();
const {id, message } = location.state;
const [data, setData] = useState([]);
const [loading, setLoading] = useState(true);
const [error, setError] = useState(null);

useEffect(() => {
  const fetchData = async () => {
    try {
      const response = await MovieService.getMovieById(id); // Example API
      setData(response.data);
      setLoading(false);
    } catch (err) {
      setError(err.message);
      setLoading(false);
    }
  };
  fetchData();
}, [id]); 
console.log(data);
  if (loading) return <div>Loading...</div>;
  if (error) return <div>Error: {error}</div>;
 return (
    
	<div className='container'>
    {message && <div className="alert-success">{message}</div>}
		<div className='mt-3'>
		<h1 className="text-center">IMDb Movie</h1>
    <div>
        <MovieTable movies={[data]} page={1} />    
    </div>
		</div>
    <Link to='/imdbmovie'>Goto Movie Page</Link>
	</div>

	)
}
export default AfterUpdate
