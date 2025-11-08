
import React,{ useState} from 'react';
import MyForm from './MyForm';
import { fetchData } from './Api';
import MyDropdown from './DropDownList';
import { selectData } from './SelectedValue';
import Pagination from './Pagination';
import { Link } from 'react-router-dom'
function FetchData() {
	const [data, setData] = useState([])
    const [selectedValue, setSelectedValue] = useState('');
    const [currentPage,setCurrentPage] = useState(1)
    const [postsPerPage, setPostsPerPage] = useState(10)
    const handleDropdownChange = (value) => {
    setSelectedValue(value);
  };
    
    const handleSearch = async ( query) => {
    try {
        var ddlData = selectData (selectedValue);
        if(query === '') {query = '000000'}
        var data = await fetchData(ddlData, query);
        setData(data);
    } catch (error) {
      setData({ error: "Failed to fetch data." });// Handle error, e.g., display an error message
    }
  };
    const lastPostIndex = currentPage * postsPerPage;
    const fistPostIndex = lastPostIndex - postsPerPage;
    const currentPosts = data?.slice(fistPostIndex, lastPostIndex)
    var movieSize;
    if (!data.length === null || !data.length === "" || data.length > 1 ) 
        movieSize = "s";
	return (
	<div className='container'>
        Search with <MyDropdown  onSelectChange={handleDropdownChange} />
        <MyForm onSearch={handleSearch} />
		<div className='mt-3'>
		<h1 className="text-center">Imdb Movie Lists </h1>
                <table className="table table-striped">
                    <thead>
                        <tr>
                            <td>Imdb ID</td>
                            <td>Movie Name</td>
                            <td>Released Year</td>
                            <td>Run Time</td>
                            <td>Genre</td>
                            <td>Total Rating</td>
                            <td>Rating</td>
                            <td>Director</td>
                            <td>Cast</td>
                            <td>Summary</td>
                            <td>Action</td>
                        </tr>
                    </thead>
                    <tbody>
                        {
                            currentPosts?.map(
                                movie =>
                                    <tr key={movie.imdbId}>
                                        <td>{movie.imdbId}</td>
                                        <td>{movie.name}</td>
                                        <td>{movie.year}</td>
                                        <td>{movie.runTime}</td>
                                        <td>{movie.genre?.map(genre => <div>{genre}</div>)}</td>
                                        <td>{movie.ratingCount}</td>
                                        <td>{movie.ratingValue}</td>
                                        <td>{movie.director}</td>
                                        <td>{movie.cast?.map(cast => <div>{cast.name}</div>)}</td>
                                        <td>{movie.summaryText}</td>
                                        <td><Link className="btn btn-info" to={`/edit-imdbmovie/${movie.imdbId}`} >Update Summary</Link></td>
                                    </tr>
                            )
                        }
                    </tbody>
                </table>
                Total Record{movieSize}: {data?.length}{setPostsPerPage}
                <Pagination totalPosts={data?.length}
                            postsPerPage={postsPerPage}
                            setCurrentPage={setCurrentPage}
                            curentPage={currentPage}
                />
		</div>
	</div>
	)
}
export default FetchData
