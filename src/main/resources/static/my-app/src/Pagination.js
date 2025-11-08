import React from 'react';
const Pagination = ({ totalPosts, postsPerPage, setCurrentPage, curentPage}) => {
    let pages = [] ;
    for (let i = 1; i < Math.ceil(totalPosts/ postsPerPage)+1; i++) {
        pages.push(i);
    }

    return (      
        <div className='pagination'>
            {
                pages.map((page,index) => {
                    return <button key={index} onClick={() => setCurrentPage(page)} 
                    className={page === curentPage ? 'active' : ''}>{page}</button>
                })
            }
        </div>
    )
}

export default Pagination