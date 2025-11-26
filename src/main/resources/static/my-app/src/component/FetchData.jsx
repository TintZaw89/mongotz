
import React,{ useState} from 'react';
import MyForm from './MyForm';
import { fetchData } from './Api';
import MyDropdown from './DropDownList';
import { selectData } from './SelectedValue';
import Pagination from './Pagination';
import MovieTable from './MovieTable';
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
        setCurrentPage(1);
    } catch (error) {
      setData({ error: "Failed to fetch data." });// Handle error, e.g., display an error message
    }
  };

    const lastPostIndex = currentPage * postsPerPage;
    const fistPostIndex = lastPostIndex - postsPerPage;
    const currentPosts = data?.slice(fistPostIndex, lastPostIndex)
    let movieSize;
    if (!data.length === null || !data.length === "" || data.length > 1 ) 
        movieSize = "s";

	return (

	<div className='container'>
        <div>
        Search with <MyDropdown  onSelectChange={handleDropdownChange} />
        <MyForm onSearch={handleSearch} />
        </div>
		<div className='mt-3'>
		<h1 className="text-center">Imdb Movie Lists </h1>
    <div>
        <MovieTable movies={currentPosts}/>    
        Total Record{movieSize}: {data?.length}{setPostsPerPage}
        <Pagination totalPosts={data?.length}
                    postsPerPage={postsPerPage}
                    setCurrentPage={setCurrentPage}
                    curentPage={currentPage}
    
        />
    </div>
		</div>
	</div>

	)
}
export default FetchData
